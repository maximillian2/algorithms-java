package nau.algorithms;

/**
 *
 * Created by maxi on 15.02.16.
 */

public class TreeNode {

    // make protected
    public TreeNode leftNode, rightNode;
    // make private
    public Student data;

    public TreeNode(Student student)
    {
        data = student;
    }
    public Integer getDataValue()
    {
        return  data.getStudentsTicket();
    }

    @Override
    public String toString() {
        return data.toString();
    }
}
