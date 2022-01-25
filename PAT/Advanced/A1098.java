public class A1098 {
    public static void main(String[] args) {

    }

    /**
     * insert sort
     *
     * @param arr
     * @param index µÚ¼¸´Î
     */
    public static void insertSort(int[] arr,int index){
        int length = arr.length;
        int temp,min=arr[index-1],i=index-1;
        for (; i < length; i++) {
            if(min>arr[i]){
                min = arr[i];
            }
        }
        temp = arr[index-1];
        arr[index-1] = min;
        arr[i] = temp;
    }

    public static void heapSort(int[] arr){

    }
}
