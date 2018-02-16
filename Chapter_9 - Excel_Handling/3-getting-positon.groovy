def ans =[]
excelstudy{
    excelfile '/home/bhanuchander/dude/2018/SNC-Parameters.xlsx'
    getdata('Sheet1').each{row ->
        ans.clear()
        ans[0]=row[0]
        row.drop(1).each{

            if (it != "NULL" && it.contains('aEnd')){
                ans[it.tokenize(':')[0].replaceAll("[^\\d.]", "").toInteger()]=it
            }
            else if (it != "NULL" && it.contains('zEnd')){
                ans[it.tokenize(':')[0].replaceAll("[^\\d.]", "").toInteger()+6]=it
            }
        }

        println ans.join(',')
    }
}
