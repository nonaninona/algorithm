import java.io.*
import java.util.*


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine())

    val N = st.nextToken().toInt()
    val M = st.nextToken().toInt()

    val A = IntArray(N)
    val B = IntArray(M)

    st = StringTokenizer(br.readLine())
    for(i in 0 until N)
        A[i] = st.nextToken().toInt()
    st = StringTokenizer(br.readLine())
    for(i in 0 until M)
        B[i] = st.nextToken().toInt()

    A.sort()
    B.sort()

    var win = 0L
    var lose = 0L
    var draw = 0L

    var winIdx = 0
    var drawIdx = 0
    for(score in A) {
        while(winIdx < M && B[winIdx] < score) {
            winIdx++
        }

        while(drawIdx < M && B[drawIdx] <= score) {
            drawIdx++;
        }

        win += winIdx;
        draw += (drawIdx - winIdx)
        lose += (M - drawIdx)
    }

    println("$win $lose $draw")
}