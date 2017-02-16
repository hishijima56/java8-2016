#!/usr/bin/jjs -scripting
/*
 * 練習問題07_06
 *
 */
function pipe() {
	for (var i = 0; i < arguments.length; i++) {
		$EXEC(arguments[i], $OUT);
	}
}

pipe('java -version');
// pipe('ls', 'sort');
print($OUT)
