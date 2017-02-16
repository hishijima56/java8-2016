#!/usr/bin/jjs

/*
 * 練習問題07_03
 */
//BigIntegerインスタンス呼び出し
var b = new java.math.BigInteger('1234567890987654321')
//表示 → 1234567890987654321
print(b)

//→ 1
print(b.mod(java.math.BigInteger.TEN))

//表示方法を変える → 1234567890987654400
print(Number(b))