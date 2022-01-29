import java.util.*;

/**
 * Copyright (C), Peter GUAN
 * FileName: FindModeInBST
 * Author:   Peter
 * Date:     28/01/2022 10:05
 * Description: https://leetcode-cn.com/problems/find-mode-in-binary-search-tree/
 * History:
 * Version:
 */
public class FindModeInBST {
    ArrayList<Integer> res;
    int maxCount;
    int count;
    TreeNode pre;

    public int[] findMode(TreeNode root) {
        // Here, we are not going to consider the property of BST

        List<Integer> res = new ArrayList<>();
        List<Integer> inorderTraversal = inorderTraversalIteration(root);

        // 统计数据出现的次数
        // todo: Try to figure out how to sort a dictionary according to the value and output the max or min one.
        Map<Integer, Integer> table = new TreeMap<>();
        for (Integer num : inorderTraversal) {
             table.put(num, table.getOrDefault(num, 0) + 1);
        }
        // 根据value排序
        List<Map.Entry<Integer, Integer>> mapList = new ArrayList<Map.Entry<Integer, Integer>>(table.entrySet());

        Collections.sort(mapList,new Comparator<Map.Entry<Integer, Integer>>() {
            //升序排序
            public int compare(Map.Entry<Integer, Integer> o1,
                               Map.Entry<Integer, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }

        });

        for (int i = 1; i < mapList.size(); i++) {
            if (mapList.get(i).getValue() == mapList.get(i - 1).getValue()) {
                res.add(mapList.get(i).getKey());
            } else {
                break;
            }
        }

        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    public List<Integer> inorderTraversalIteration(TreeNode root) {
        // 使用通用迭代算法进行前序遍历, 再DFS中， 使用栈进行数据储存， 并且我们将使用null指针来记录null前的数据是否被访问过， 如果访问过
        // 我们将添加到res数组， 如果没有我们将添加他的子孙节点

        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();

        if (root!=null) {
            stack.push(root);
        }

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();

            if (node != null) {
                if (node.right != null) {
                    stack.push(node.right);
                }
                // 添加null标记
                stack.push(node);
                stack.push(null);
                if (node.left != null) {
                    stack.push(node.left);
                }
            } else {
                node = stack.pop();
                res.add(node.val);
            }

        }

        return res;
    }

    public int[] findMode2(TreeNode root) {
        res = new ArrayList<>();
        maxCount = 0;
        count = 0;
        pre = null;
        findMode1(root);
        int[] resList = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            resList[i] = res.get(i);
        }
        return resList;
    }

    public void findMode1(TreeNode root) {
        if (root == null) {
            return;
        }

        findMode1(root.left);

        int rootVal = root.val;
        // 计数
        if (pre == null || rootVal != pre.val) {
            count = 1;
        } else {
            count++;
        }
        // 更新结果
        if (count > maxCount) {
            res.clear();
            res.add(rootVal);
            maxCount = count;
        } else if (count == maxCount) {
            res.add(rootVal);
        }
        pre = root;

        findMode1(root.right);
    }
}
