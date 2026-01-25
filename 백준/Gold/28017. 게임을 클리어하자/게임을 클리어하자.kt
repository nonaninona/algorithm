import java.io.*
import java.util.*

var dp = Array(1) { IntArray(1) }
var N = 1
var M = 1
var T = Array(1) { IntArray(1) }

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine())

    N = st.nextToken().toInt()
    M = st.nextToken().toInt()

    T = Array(N) { IntArray(M) { -1 } }

    for(i in 0 until N) {
        st = StringTokenizer(br.readLine())
        for (j in 0 until M)
            T[i][j] = st.nextToken().toInt()
    }

    dp = Array(N) { IntArray(M) { -1 } }
    for(i in 0 until M)
        dp[0][i] = T[0][i]

    var ans = Int.MAX_VALUE
    for(i in 0 until M)
        ans = Math.min(ans, dfs(N - 1, i))

    println(ans)

//    for(i in 0 until N) {
//        for (j in 0 until M) {
//            print("${dp[i][j]} ")
//        }
//        println()
//    }
}

fun dfs(round: Int, curWeapon: Int): Int {
//    println("$round $curWeapon")

    if(dp[round][curWeapon] != -1)
        return dp[round][curWeapon]

    var ret = Int.MAX_VALUE

    for(i in 0 until M) {
        if (i == curWeapon)
            continue

        ret = Math.min(ret, dfs(round - 1, i))
    }

    ret += T[round][curWeapon]

    dp[round][curWeapon] = ret

    return dp[round][curWeapon]
}
