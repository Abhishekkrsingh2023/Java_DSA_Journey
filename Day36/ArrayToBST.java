import java.util.ArrayList;
public class ArrayToBST {
    static void preorder(int []arr,int st,int end,ArrayList<Integer> ans){
        if(st > end) return;
        int mid = st+(end-st)/2;
        ans.add(arr[mid]);
        preorder(arr, st, mid-1, ans);
        preorder(arr, mid+1, end, ans);
    }
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6};
        ArrayList<Integer> ans = new ArrayList<>();
        preorder(arr,0,arr.length-1,ans);
        System.out.println(ans);
    }
}
