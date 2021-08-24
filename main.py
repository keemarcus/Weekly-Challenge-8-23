def collatzSequence(n):
    count = 0
    while n != 1:
        if n % 2 == 0:
            n /= 2
        else:
            n = (3 * n) + 1
        count += 1
    return count


def collatz(a, b):
    aCount = collatzSequence(a)
    bCount = collatzSequence(b)
    if aCount < bCount:
        return "a"
    elif bCount < aCount:
        return "b"
    else:
        return "same"


print(collatz(10, 15))
print(collatz(13, 16))
print(collatz(53782, 72534))
