class Git
{
  String url
  Git(String url_name)
  {
    url = url_name
  }
    
  String getreponame()
  {
      String gitname = ("basename $url").execute().getText().trim()
      return gitname.take(gitname.lastIndexOf('.'))
   }

}
