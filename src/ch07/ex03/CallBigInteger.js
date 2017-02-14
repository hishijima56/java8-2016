/*
 * 練習問題07_03
 * javaのAPIを呼び出す
 */
//BigIntegerインスタンス呼び出し
var b = new java.math.BigInteger('1234567890987654321')
//表示
print(b)

print(b.mod(java.math.BigInteger.TEN))

print(Number(b))