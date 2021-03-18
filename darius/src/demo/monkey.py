def fun(x):
    if x > 1:
        return fun(x) * 2 + 1
    if x == 1:
        return 1


fun(10)
