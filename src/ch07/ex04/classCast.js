#!/usr/bin/jjs

/*
 * 練習問題07_04
 */
//js文字列生成
var text = 'aabbccdksrhak';
var str = text.slice(-7);
//getClass()呼び出し -> java.lang.String
print(str.getClass());

//java.lang.String.class.castへ渡す ->文字列がでてくる
print(java.lang.String.class.cast(str));