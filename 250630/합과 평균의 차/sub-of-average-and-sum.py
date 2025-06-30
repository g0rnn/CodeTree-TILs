a, b, c = map(int, input().split())
s = a+b+c
avg = int(s/3)
print(s, avg, s-avg, sep="\n")