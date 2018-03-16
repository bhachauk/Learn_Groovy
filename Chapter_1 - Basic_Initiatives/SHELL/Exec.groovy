

class Exec{
    String cmd
    Exec(String command)
    {
        cmd = command
    }
    def exec()
    {
        def execution = cmd.execute()
        execution.waitFor()
        return execution
    }

    String exec_getresult ()
    {
        return (exec().getText())
    }

    void exec_here()
    {
        def exectuion =cmd.execute()
        exectuion.waitForProcessOutput(System.out, System.err)
    }
    
    def exec_piped_list (List <String> join_list)
    {
	    return join_list*.execute().inject{a,b -> a | b}
    }

}
