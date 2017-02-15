/*
 * $Header: $
 * $Revision: $
 * $Date: $
*/

package ch08.ex07;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 練習問題08_07
 * @author Hidetoshi Ishijima
 *
 * @version $Revision: $ $Date: $
 * @since 2017/02/14
 */
public class SortSample {

    /**
     * mainメソッド
     * @param args 実行時引数
     */
    public static void main(String[] args) {
        Person[] people = new Person[11];
        people[0] = new Person("John","Quincy","Adams");
        people[1] = new Person("Martin","Van","Buren");
        people[2] = new Person("William","Henry","Harrison");
        people[3] = new Person("William",null,"Mckinley");
        people[4] = new Person("James","Earl","Carter");
        people[5] = new Person("Ronald","Wilson","Reagan");
        people[6] = new Person("George","Herbert Walker","Bush");
        people[7] = new Person("William","Jefferson","Clinton");
        people[8] = new Person("George","Walker","Bush");
        people[9] = new Person("Barack","Hussein","Obama");
        people[10] = new Person("Donald","John","Trump");

        //見本のやり方
//        Arrays.sort(people, Comparator.comparing(Person::getMiddleName ,Comparator.nullsFirst(Comparator.naturalOrder()).reversed())); ←コンパイルエラー
        Arrays.sort(people, Comparator.comparing(Person::getMiddleName ,Comparator.nullsLast(Comparator.reverseOrder())));
        for(Person p : people){
            System.out.println(p.getFirstName()+","+ p.getMiddleName()+","+ p.getFamilyName());
        }
    }

    private static class Person {

        private String firstName;

        private String middleName;

        private String familyName;

        private Person(String firstName, String middleName, String familyName) {
            this.firstName = firstName;
            this.middleName = middleName;
            this.familyName = familyName;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getMiddleName() {
            return middleName;
        }

        public void setMiddleName(String middleName) {
            this.middleName = middleName;
        }

        public String getFamilyName() {
            return familyName;
        }

        public void setFamilyName(String familyName) {
            this.familyName = familyName;
        }



    }
}
