def solution(genres, plays):
    plays_per_genres = {}
    
    N = len(genres)
    for i in range(N):
        if genres[i] not in plays_per_genres:
            plays_per_genres[genres[i]] = []
        plays_per_genres[genres[i]] += [(plays[i], i)]
    
    # print(plays_per_genres)
    
    genres_count = []
    for key in plays_per_genres.keys():
        playlist = plays_per_genres[key]
        playlist.sort(key = lambda x : (-x[0], x[1]))
        plays_per_genres[key] = playlist
        
        count = 0
        for p, i in playlist:
            count += p
        genres_count.append((count, key))
        
    genres_count.sort(key = lambda x : -x[0])
    
    # print(genres_count)
    # print(plays_per_genres)
    
    result = []
    for count, g in genres_count:
        playlist = plays_per_genres[g]
        result.append(playlist[0][1])
        if 2 <= len(playlist):
            result.append(playlist[1][1])
    
    # print(result)
    
    answer = result
    return answer