def a = [[[['apr','june']]]]


def printThis(List inlist)
{
    inlist.each{ val ->

        if(val instanceof List)
        {
            printThis(val)
        }
        else{

            println val
        }

    }

}

printThis(a)
