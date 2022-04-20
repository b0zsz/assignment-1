public class MyArrayList<T> implements MyList<T>{

    private Object[] arr;
    private int length = 0;
    private int capacity = 3;

    public MyArrayList() {
        arr = new Object[capacity];
    }

    @Override
    public void add(T item) {
        if (length == capacity)
            increaseCapacity();

        arr[length++] = item;
    }

    @Override
    public void add(T item, int index) {
        if (index < 0 || index > length) {
            System.out.println("index out of boundary");
            return;
        }
        for(int i=length; i>index; i--) {
            arr[i] = arr[i - 1];
        }
        arr[index] = item;
        length++;
    }

    @Override
    public boolean remove(T item) {
        if(contains(item)==true){
            remove(indexOf(item));
            return true;
        }else{
            return false;
        }

    }

    @Override
    public T remove(int index) {
        Object ans = null;
        if(index < 0 || index >= size()){
            System.out.println("some troubles");
        }else{
            ans = arr[index];
            arr[index] = null;
            length = length - 1;
        }
        return (T)ans;

    }

    @Override
    public Object clear() {
        for (int i = 0; i < length; i++) {
            arr = null;
        }
        capacity = 3;
        length = 0;
        return null;
    }

    private void increaseCapacity() {
        capacity = 2 * capacity;
        Object[] old = arr;
        arr = new Object[capacity];

        for (int i = 0; i < old.length; i++)
            arr[i] = old[i];
    }

    @Override
    public T get(int index) {
        return (T)arr[index];
    }

    @Override
    public int indexOf(Object o) {
        for(int i=0; i<arr.length; i++)
            if(o.equals(arr[i]) ) return i;
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        for(int i=arr.length-1; i>=0; i--)
            if(o.equals(arr[i])) return i;
        return -1;
    }

    @Override
    public void sort(int[] arr, int n) {
        if (n == 1)

            for (int i=0; i< n-1; i++)
                if (arr[i] > arr[i+1])
                {
                    int temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                }
        sort(arr, n-1);
    }
    
    @Override
    public int size() {
        return length;
    }

    @Override
    public boolean contains(Object o) {
        for (Object value : arr) {
            if (o.equals(value)) return true;
        }
        return false;
    }
}

