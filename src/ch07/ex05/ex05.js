#!/usr/bin/jjs

/*
 * 練習問題07_05
 */
//facrory作成
function arrFactory(){
	var arr = new (Java.extend(java.util.ArrayList)){
		add:function(x){
			print('Adding ' + x);
			return Java.super(arr).add(x)
		}
	}
	return arr;
}

var array1 = arrFactory();
var array2 = arrFactory();

for(var i = 0; i<5;i++){
	array1.add(i);
}
for(var j = 5; j>0;j--){
	array2.add(j);
}
