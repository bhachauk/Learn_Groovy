@Grab('com.xlson.groovycsv:groovycsv:1.1')
@Grab(group='org.apache.commons', module='commons-math3', version='3.6.1')
import org.apache.commons.math3.ml.clustering.DBSCANClusterer
import org.apache.commons.math3.ml.clustering.DoublePoint
import org.apache.commons.math3.ml.clustering.FuzzyKMeansClusterer
import org.apache.commons.math3.ml.clustering.KMeansPlusPlusClusterer
import org.apache.commons.math3.ml.clustering.MultiKMeansPlusPlusClusterer
import org.apache.commons.math3.ml.clustering.CentroidCluster
import static com.xlson.groovycsv.CsvParser.parseCsv
df = new FileReader('/home/bhanuchander/course/Learn_Groovy/Chapter_9-Machine_Learning/data.csv')
Map<String, double[]> dfMap = [:]
for (line in parseCsv (df))
{
    double [] point= [line.temp.toDouble(), line.humidity.toDouble()]
    dfMap[line.city] = point
}

ClusterWork clusterWork = new ClusterWork (dfMap)

def showClosure = {detail ->
println "Cluster : " + detail.cluster + " Point : " + detail.point + " Label : "+ detail.labels
}

println 'DBSCAN'
clusterWork.dbscan(6, 0).each(showClosure)
println '-----------'

println 'Kmean'
clusterWork.kmean( 5).each(showClosure)
println '-----------'

println 'FuzzyKMean'
clusterWork.fuzzykmean(5, 300).each(showClosure)
println '-----------'

println 'MultipleKMean'
clusterWork.multiplekmean(5, 5).each(showClosure)
println '-----------'

class ClusterWork
{
    List<DoublePoint> points = new ArrayList<DoublePoint>()
    Map<DoublePoint, List<String>> pointMap = [:]

    ClusterWork(Map table)
    {
        table.each{ k,v ->
            DoublePoint dArr = new DoublePoint(v)
            points.add(dArr)

            if (!(dArr in pointMap.keySet()))
                pointMap[dArr] = []
            pointMap[dArr].add(k)
        }
    }

    List<ClusterDetail> dbscan (double d, int i)
    {
        DBSCANClusterer DBScan = new DBSCANClusterer(d, i)
        collectDetails DBScan.cluster(this.points)
    }

    List<ClusterDetail> fuzzykmean (int k, double fuzziness)
    {
        FuzzyKMeansClusterer fKMean = new FuzzyKMeansClusterer(k, fuzziness)
        collectDetails fKMean.cluster(this.points)
    }

    List<ClusterDetail> multiplekmean (int k, int trials)
    {
        MultiKMeansPlusPlusClusterer mkppc = new MultiKMeansPlusPlusClusterer(new KMeansPlusPlusClusterer(k), trials)
        collectDetails mkppc.cluster(this.points)
    }

    List<ClusterDetail> kmean (int k)
    {
        KMeansPlusPlusClusterer kMean = new KMeansPlusPlusClusterer(k)
        collectDetails kMean.cluster(this.points)
    }
    private List<ClusterDetail> collectDetails( List<CentroidCluster> clusters)
    {
        List<ClusterDetail> ret = []
//        println clusters.class.name
        clusters.eachWithIndex{ c, ci ->
            c.getPoints().each { pnt ->
                DoublePoint pt = pnt as DoublePoint
                ret.add new ClusterDetail (ci + 1 as Integer, pt, this.pointMap[pt])
            }
        }
        ret
    }
}


class ClusterDetail
{
    int cluster
    DoublePoint point
    List<String> labels

    ClusterDetail(int no, DoublePoint pt, List<String> labs)
    {
        cluster = no; point= pt; labels = labs
    }
}