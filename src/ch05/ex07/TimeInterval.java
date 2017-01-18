package ch05.ex07;
import java.time.LocalDateTime;
import java.util.Objects;

/*
 * $Header: $
 * $Revision: $
 * $Date: $
*/

/**
 * 練習問題05_07
 * @author Hidetoshi Ishijima
 *
 * @version $Revision: $ $Date: $
 * @since 2017/01/16
 */
public class TimeInterval {

    /**
     * 開始日時
     */
    private final LocalDateTime startDateTime;

    /**
     * 終了日時
     */
    private final LocalDateTime endDateTime;

    /**
     * コンストラクタ
     * @param startDateTime 開始日時
     * @param endDateTime 終了日時
     */
    public TimeInterval(LocalDateTime startDateTime, LocalDateTime endDateTime) {
        Objects.requireNonNull(startDateTime, "開始日時はnullではいけません。");
        Objects.requireNonNull(endDateTime, "終了日時はnullではいけません。");
        if(startDateTime.isAfter(endDateTime)){
            throw new IllegalArgumentException("終了日時は開始日時よりも後に設定して下さい。");
        }

        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
    }

    /**
     * 開始日時を取得します。
     * @return 開始日時
     */
    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }

    /**
     * 終了日時を取得します。
     * @return 終了日時
     */
    public LocalDateTime getEndDateTime() {
        return endDateTime;
    }

    /**
     * TimeIntervalが重なっているかを返します。
     * @param other 比較対象
     * @return true/false 重なっている場合はtrue,重なっていない場合はfalse;
     */
    public boolean isConflict(TimeInterval other){
        //otherがnullの場合はfalse
        if(other == null || other.getStartDateTime() == null || other.getEndDateTime() == null){
            return false;
        }
        //開始時刻が等しい場合はtrue
        if(this.startDateTime.isEqual(other.getStartDateTime())){
            return true;
        }

        return this.startDateTime.isAfter(other.getStartDateTime()) ? !(this.startDateTime.isAfter(other.getEndDateTime())) : !(this.endDateTime.isBefore(other.getStartDateTime())) ;

    }
}
