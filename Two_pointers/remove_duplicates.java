package Two_pointers;
class remove_duplicates{
    public static void main(String[] args) {
        int[] arr = {2, 3, 3, 3, 6, 9, 9};
        System.out.println(remove(arr));
    }
    public static int remove(int[] arr) {
        int i =0;//for tracking unique elements
        for(int j=1;j<arr.length;j++){//j is for traversing the array
            if(arr[i]!=arr[j]){
                arr[i+1] = arr[j];
                i++;
            }
        }
        return i+1;
        }
}