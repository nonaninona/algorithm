from datetime import datetime, timedelta

def solution(lines):
    datetimes = []
    datetimeranges = []
    for l in lines:
        start, end = parse_datetime(l)
        datetimes.append(start)
        datetimes.append(end)
        datetimeranges.append((start, end))
    datetimes.sort()
    
    # print(datetimes)
    # print(datetimeranges)
    
    global_max = 0
    for s in datetimes:
        e = s + timedelta(microseconds = 999000)
        # print(s, e)
        local_max = 0
        for a, b in datetimeranges:
            if e < a or b < s:
                continue
            local_max += 1
        global_max = max(global_max, local_max)
    
    # print(global_max)
        
    answer = global_max
    return answer

def parse_datetime(datetime_string):
    date_string, time_string, duration_string = datetime_string.split(" ")
    y, month, d = date_string.split("-")
    # print(y, month, d)
    h, minute, second = time_string.split(":")
    s, ms = second.split(".")
    # print(h, minute, s, ms)
    d_second = duration_string[:-1]
    ds, dms = 0, 0
    if "." in d_second:
        ds, dms = d_second.split(".")
    else:
        ds = d_second
    # print(ds, dms)
    
    end = datetime(int(y), int(month), int(d), int(h), int(minute), int(s), int(ms) * 1000)
    start = end - timedelta(seconds = int(ds), microseconds = int(dms) * 1000) + timedelta(microseconds = 1000)
    # print(start, end)
                            
    return start, end