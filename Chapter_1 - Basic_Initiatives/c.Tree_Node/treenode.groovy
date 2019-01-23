List<String> a = ['a','b','c']
List<TreeNode> temp = []
a.each{ val ->
    TreeNode tn = new TreeNode(val,temp)
    temp=[]
    temp.add(tn)
}
TreeNode rootTree = new TreeNode('root', temp)
rootTree.print()

//rootTree.print()

class TreeNode {

    final String name
    final List<TreeNode> children

    TreeNode(String name, List<TreeNode> children) {
        this.name = name
        this.children = children
    }

    private void print() {
        print("", true)
    }

    private void print(String prefix, boolean isTail) {
        System.out.println(prefix + (isTail ? "└── " : "├── ") + name)
        if (!children.isEmpty()) {
            for (int i = 0; i < children.size() - 1; i++) {
                children.get(i).print(prefix + (isTail ? "    " : "│   "), false)
            }
        }
        if (children.size() > 0) {
            children.get(children.size() - 1)
                    .print(prefix + (isTail ? "    " : "│   "), true)
        }
    }
}