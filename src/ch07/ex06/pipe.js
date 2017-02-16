#!/usr/bin/jjs -scripting
/*
 * 練習問題07_06
 *
 */
function pipe(args) {
	print(args.length);
	if (args.length > 0) {
		$EXEC(args);
		if (args.length > 1) {

			for (index in args) {
				$EXEC(args(index), $out);
			}
		}
	}
}

pipe('ls' , 'grep pipe', 'sort');

print($out)