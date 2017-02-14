/*
 * 練習問題07_09
 *
 */
//実行時引数から受付
var userYear = Number(arguments[0]);
if(isNaN(userYear)){
	//環境変数AGEから受付
	userYear = Number($ENV.AGE);
	while(isNaN(userYear)){
		//ユーザに入力させる
		userYear = Number(readLine('How old are you? : '));
	}
}
//翌年の年齢を表示する
print('Next year, you will be '+ (userYear + 1) + ' years old.');
