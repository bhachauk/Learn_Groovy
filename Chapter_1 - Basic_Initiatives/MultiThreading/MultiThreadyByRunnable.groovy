import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

List data1 =[]
List data2  =[]
Runnable r1 = new Runnable() {
    void run() {
    int i = 0
    10000.times{
        i++
        data1 << i
    }
}}
// t1.join()
Runnable r2 = new Runnable() {
    void run() {
        i =0
        50000.times{
            i++
            data2 << i
        }
    }
}
//t1.join()
//t2.join()

ps = Runtime.getRuntime().availableProcessors()
println "Available Threads : " + ps.toString()
ExecutorService executor = Executors.newFixedThreadPool(1)
executor.execute(r1)
executor.execute(r2)
executor.shutdown()
// Wait until all threads are finish
executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS)
println "Is terminated : " + executor.isTerminated()
data = data2.minus(data1)
println data.size()