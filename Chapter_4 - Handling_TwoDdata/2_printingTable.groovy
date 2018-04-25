@Grab(group='com.massisframework', module='j-text-utils', version='0.3.4')

import dnl.utils.text.table.TextTable

// File to list of list

List<List<String>> tokefile = new File('test.txt').readLines().collect{ it.tokenize('|')}


// data to 2d array


String[][] array = new String[tokefile.size()][];

for (int i = 0; i < tokefile.size(); i++) 
{
    ArrayList<String> row = tokefile.get(i);
    array[i] = row.toArray(new String[row.size()]);
}

// Columns and Data

String[] col = ['1','2','3','4','5']

TextTable tt = new TextTable(col, array);


tt.printTable()


/*
------------------------------------------
____________________________________________________________________________________________________
| 1             | 2                  | 3                     | 4      | 5                           |
|===================================================================================================|
| AttachmentName| CreationDateTime   | ID                    | MailBox| Processed                   |
| 1279_001.pdf  | 20180411 121519.761| scanning_40           | N      | FW: TNT Belgium - 020202    |
| 1296_001.pdf  | 20180411 121519.793| scanning_41           | N      | FW: Wedig truck of yesterday|


*/
