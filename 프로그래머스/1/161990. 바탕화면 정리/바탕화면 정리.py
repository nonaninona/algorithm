def solution(wallpaper):
    left, up, right, down = 50, 50, 0, 0

    for y, row in enumerate(wallpaper):
        for x, b in enumerate(row):
            if b == "#":
                left = min(left, x)
                up = min(up, y)
                right = max(right, x+1)
                down = max(down, y+1)

    # print(up, left, down, right)
    answer = [up, left, down, right]
    return answer