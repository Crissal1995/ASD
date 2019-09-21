%%
noe = get_number_elems(counting);

%%
counting = loading("CountingSort.txt");
v_count = get_value(counting);
figure
plot(noe, v_count, "-o");
xlabel("Number of elements");
ylabel("Time [ms]");
title("Counting Sort [K = 800]");
hold on
plot(noe, 1.7e-5*noe, "-x");
hold off
legend("Counting sort", "O(n)")
grid

%%
bucket = loading("BucketSort.txt");
v_bucket = get_value(bucket);
figure
plot(noe, v_bucket, "-o");
xlabel("Number of elements");
ylabel("Time [ms]");
title("Bucket sort");
hold on
plot(noe, 2e-4*noe - 10, "-x");
hold off
legend("Bucket sort", "O(n)")
grid

%%
heap = loading("HeapSort.txt");
v_heap = get_value(heap);
figure
plot(noe, v_heap, "-o");
xlabel("Number of elements");
ylabel("Time [ms]");
title("Heap sort");
hold on
plot(noe, 2.5e-5*noe.*log2(noe), "-x");
hold off
legend("Heap sort", "O(n lgn)")
grid

%%
merge = loading("MergeSort.txt");
v_merge = get_value(merge);
figure
plot(noe, v_merge, "-o");
xlabel("Number of elements");
ylabel("Time [ms]");
title("Merge sort");
hold on
plot(noe, 1.5e-5*noe.*log2(noe), "-x");
hold off
legend("Merge sort", "O(n lgn)")
grid

%%
quick = loading("QuickSort.txt");
v_quick = get_value(quick);
figure
plot(noe, v_quick, "-o");
xlabel("Number of elements");
ylabel("Time [ms]");
title("Quick sort");
hold on
plot(noe, 1.3e-5*noe.*log2(noe), "-x");
hold off
legend("Quick sort", "O(n lgn)")
grid

%%
rand = loading("RandQuickSort.txt");
v_rand = get_value(rand);
figure
plot(noe, v_rand, "-o");
xlabel("Number of elements");
ylabel("Time [ms]");
title("Randomized quick sort");
hold on
plot(noe, 2.13e-5*noe.*log2(noe)-10, "-x");
hold off
legend("Randomized quick sort", "O(n lgn)")
grid

%%
% Con insertion sort abbiamo meno elementi a causa del tempo enorme di
% esecuzione, quindi dobbiamo ottenere un nuovo noe
insertion = loading("InsertionSortInteger.txt");
v_ins = get_value(insertion);
noe_ins = get_number_elems(insertion);
figure
plot(noe_ins, v_ins, "-o");
xlabel("Number of elements");
ylabel("Time [ms]");
title("Insertion sort");
hold on
plot(noe_ins, 1e-7*noe_ins.^2, "-x");
hold off
legend("Insertion sort", "O(n^2)")
grid
