noe = dimensione;
sizes = buffer_usato;
func = 4.25e-6*noe.*log2(noe);
func2 = 0.8e-4*noe;
%%
figure
plot(noe, sizes / 1e3, "-o");
xlabel("Number of elements");
ylabel("Size occupied by algorithm [MB]");
title("Merge Sort");
hold on
%plot(noe, func, "-x");
plot(noe, func2, "-x");
hold off
legend("Merge sort", "O(n)")
grid