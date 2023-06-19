using LinearAlgebra
using RowEchelon

println("start")

n = 2000
A = rand(Float64, (n, n));

function small_operations()
	for i = 1:1000000
		B = rand(Float64, (2, 2));
		rref(B);
	end
end

#this compiles @time such that there is no compilation time in the real calls
println("precompiling @time, rref, and eigen")
@time rref([1 0; 1 1]);
@time eigen([1 0; 1 1]);


println("starting benchmark rref")
@time rref(A)

println("starting benchmark eigenvector")
@time eigen(A)

println("starting benchmark 10^6 cheap operations")
@time small_operations()