package lotto.service

class Yeild {
    enum class ranking(val value : Int) {
        THREE(5000),
        FOUR(50000),
        FIVE(1500000),
        SIX(2000000000),
        FIVEBONUS(30000000)
    }
    fun plusMoney(buyLottoMoney: String, checkWinningScore: MutableList<Int>): Double {
        val buyLottoMoney = buyLottoMoney.toInt() * 1000
        var getMoney = 0
        getMoney += checkWinningScore[0] * ranking.THREE.value
        getMoney += checkWinningScore[1] * ranking.FOUR.value
        getMoney += checkWinningScore[2] * ranking.FIVE.value
        getMoney += checkWinningScore[3] * ranking.FIVEBONUS.value
        getMoney += checkWinningScore[4] * ranking.SIX.value
        val yieldUser: Double = getMoney.toDouble() / buyLottoMoney.toDouble()
        println(yieldUser * 100)
        return yieldUser
    }
}