// Various methods to read a file

// 1.each line :

new File ('/tmp/orochimaru_doc.txt').eachLine 
{ line,number ->
    println 'line.no : '+number+' line : '+line
}

// 2.get the exact line

String get_line (Integer lno, String filename)
{
    return (new File (filename).readLines().get(lno))
}
