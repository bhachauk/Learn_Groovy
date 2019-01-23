// Inject Method

println ([0..9].inject("Numbers :"){ source, val -> source+'-'+val})

/*
OUTPUT  :
Numbers :-[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
*/

[0..9].each{ println it.inject("Numbers :"){ source, val -> source+val}}

/*
OUTPUT  :
Numbers :0123456789
*/
