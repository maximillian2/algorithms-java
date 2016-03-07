package nau.algorithms;

/**
 *
 * Created by maxi on 15.02.16.
 */

public class Tree {
    private TreeNode root;

    public Tree() {}

    public boolean addNode(TreeNode node)
    {
        // encapsulate student into treenode here
        if(root == null)
        {
            root = node;
        } else {
            return recursiveAdd(root, node);
        }
        return true;
    }

    // make separate private method to implement recursive addition
    private boolean recursiveAdd(TreeNode root, TreeNode node)
    {
        if(root.getDataValue() > node.getDataValue())
        {
            if(root.leftNode == null)
            {
                root.leftNode = node;
            } else {
                recursiveAdd(root.leftNode, node);
            }
        }
        else if(root.getDataValue() < node.getDataValue())
        {
            if(root.rightNode == null)
            {
                root.rightNode = node;
            } else {
                recursiveAdd(root.rightNode, node);
            }
        } else {
            return false;
        }
        return true;
    }

    public void inspect()
    {
        TreeNode start = root;
        recursiveInspect(start);
    }

    private void recursiveInspect(TreeNode start)
    {
        if(start.leftNode != null)
        {
            recursiveInspect(start.leftNode);
        }
        System.out.println(start.getDataValue());
        if(start.rightNode != null)
        {
            recursiveInspect(start.rightNode);
        }
    }

    public void search(int course, double avgMark)
    {
        TreeNode start = root;
        recursiveSearch(start, course, avgMark);
    }

    private void recursiveSearch(TreeNode start, int course, double avgMark)
    {
        if(start.data.getCourse() == course && (!start.data.getCitizenShip().equals("Ukraine")) && start.data.getAverageMark() == avgMark )
        {
            System.out.println(start.data.toString());
        }

        if(start.leftNode != null)
        {
            recursiveSearch(start.leftNode, course, avgMark);
        }

        if(start.rightNode != null)
        {
            recursiveSearch(start.rightNode, course, avgMark);
        }
    }

//    public void delete(TreeNode start)
//    {
//        if(start.data.getCourse() == 1 && (!start.data.getCitizenShip().equals("Ukraine")) && start.data.getAverageMark() == 5.0 )
//        {
//            System.out.println(start.data.toString());
//        }
//
//        if(start.leftNode != null)
//        {
//            search(start.leftNode);
//        }
//        if(start.rightNode != null)
//        {
//            search(start.rightNode);
//        }
//
//    }
}
