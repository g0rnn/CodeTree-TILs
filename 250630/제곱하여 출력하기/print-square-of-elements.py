a = int(input())
l = list(map(int, input().split()))
result = [x**2 for x in l]
for i in range(len(result)):
    print(i, end=' ')