package AmazonOA.com;

import java.util.*;

class DistanceBetweenNodesInBST {

    public static void main(String[] args) {
        DistanceBetweenNodesInBST main = new DistanceBetweenNodesInBST();
        constructTreeAnyOrder consTree = new constructTreeAnyOrder();
        TreeNode root = consTree.constructATree (new int[] {10,18,12,16,19,13,20,3,1,7,14});
        System.out.println(root.left.right.val);
        TreeNode node1 = new TreeNode(18);
        TreeNode node2 = new TreeNode(7);
        //System.out.println(main.getDistance(LCA, node1));

        lowestCommonAncestor lca = new lowestCommonAncestor();
        //TreeNode LCA = lca.LCA(root, node1, node2);
        //System.out.println(LCA == null);
        //System.out.println(LCA.val);
        //TreeNode LCA = main.lowestCommonAncestor(root, node1, node2);
        //System.out.println(LCA == null);
        //System.out.println(main.getDistance(LCA, node2));



        System.out.println(main.distanceCalculator(new int[] {10,18,12,16,19,13,20,3,1,7,14}, node1, node2));
    }

    public int distanceCalculator(int[] nums, TreeNode node1, TreeNode node2){
        if(nums == null || nums.length == 0){
            return -1;
        }
        constructTreeAnyOrder consTree = new constructTreeAnyOrder();
        TreeNode root = consTree.constructATree(nums);

        lowestCommonAncestor lca = new lowestCommonAncestor();

        TreeNode LCA = lca.LCA(root, node1, node2);
        if (LCA == null){
            return -1;
        }
        //System.out.println(LCA.val);
        return getDistance(LCA, node1) + getDistance(LCA, node2);
    }

    public int getDistance(TreeNode root, TreeNode node){
        if (root.val == node.val){
            return 0;
        }

        if (node.val > root.val){
            return getDistance(root.right, node) + 1;
        }else{
            return getDistance(root.left, node) + 1;
        }
    }
    private static class lowestCommonAncestor{
        public TreeNode LCA(TreeNode root, TreeNode node1, TreeNode node2){

            resultType result = LCAHelper(root, node1, node2);
            if (list.isEmpty()){
                return null;
            }
            return list.get(0);
        }
        private List<TreeNode> list = new ArrayList<>();
        public resultType LCAHelper(TreeNode root, TreeNode node1, TreeNode node2){

            if (root == null){
                return new resultType(false, false);
            }
            resultType left = LCAHelper(root.left, node1, node2);
            resultType right = LCAHelper(root.right, node1, node2);

            boolean aExist = root.val == node1.val || left.aExist || right.aExist;
            boolean bExist = root.val == node2.val || left.bExist || right.bExist;

            if (aExist && bExist){
                list.add(root);
            }

            return new resultType(aExist, bExist);
        }

    }
    private static class resultType{
        public boolean aExist, bExist;
        public resultType(boolean aExist, boolean bExist){
            this.aExist = aExist;
            this.bExist = bExist;
        }
    }


    private static class constructTreePreOrder{
        public TreeNode constructATree(int[] nums){// The given nums should be in preorder
            if (nums == null || nums.length == 0){
                return null;
            }
            //System.out.println(constructTreeHelper(nums, Integer.MAX_VALUE));
            return Helper(nums, Integer.MAX_VALUE);
        }
        public int i = 0;
        public TreeNode Helper(int[] nums, int bound){
            if (i == nums.length || nums[i] > bound){
                return null;
            }

            TreeNode root = new TreeNode(nums[i++]);
            root.left = Helper(nums, root.val);
            root.right = Helper(nums, bound);
            return root;
        }
    }

    private static class constructTreeAnyOrder{// The given nums could be any order
        public TreeNode constructATree(int[] nums){
            TreeNode root = new TreeNode(nums[0]);

            for (int i = 1; i < nums.length; i++){
                insert(root, nums[i]);
            }
            return root;
        }
        public TreeNode insert(TreeNode root, int node){
            if (root == null) {
                return new TreeNode(node);
            }
            if (node < root.val) {
                root.left = insert(root.left, node);
            } else if (node > root.val) {
                root.right = insert(root.right, node);
            }
            return root;

        }
    }



    private static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }
}

