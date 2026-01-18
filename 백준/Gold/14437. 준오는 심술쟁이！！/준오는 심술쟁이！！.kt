import java.io.*

val br = BufferedReader(InputStreamReader(System.`in`))

var s: Int = 0
var name: String = ""
var dp = Array(3001) { IntArray(3001) { -1 } }
val MOD = 1_000_000_007

fun main() {
    s = br.readLine().toInt()
    name = br.readLine()

    println(solve(0, s))
}

fun solve(pos: Int, remain: Int): Int {
    if(dp[pos][remain] != -1)
        return dp[pos][remain]

    if(pos == name.length) {
        dp[pos][remain] = if (remain == 0) 1 else 0
        return dp[pos][remain]
    }

    var cnt = 0L
    for (i in 0..25) {
        if (remain - i >= 0) {
            cnt += solve(pos+1, remain-i)
            cnt %= MOD // 더할 때마다 모듈러
        }
    }

    dp[pos][remain] = cnt.toInt();
    return dp[pos][remain]
}
