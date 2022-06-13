package com.teamdev;

public class DataLoader {

        String[][] doName = {{
                        "전체/도",
                        "서울특별시",
                        "부산광역시",
                        "대구광역시",
                        "인천광역시",
                        "광주광역시",
                        "대전광역시",
                        "울산광역시",
                        "세종특별자치시",
                        "경기도",
                        "강원도",
                        "충청북도",
                        "충청남도",
                        "경상북도",
                        "경상남도",
                        "전라북도",
                        "전라남도",
                        "제주도" },
                        {"0", "11", "26", "27", "28", "29", "30", "31", "36", "41", "42", "43",
                "44", "47", "48", "45", "46", "50"}};

        String[][] siNameList = {
                        // 전체
                        {
                                        "전체/시/군"
                        },

                        // 서울시
                        {
                                        "전체/시/군",
                                        "종로구",
                                        "중구",
                                        "용산구",
                                        "성동구",
                                        "광진구",
                                        "동대문구",
                                        "중랑구",
                                        "성북구",
                                        "강북구",
                                        "도봉구",
                                        "노원구",
                                        "은평구",
                                        "서대문구",
                                        "마포구",
                                        "양천구",
                                        "강서구",
                                        "구로구",
                                        "금천구",
                                        "영등포구",
                                        "동작구",
                                        "관악구",
                                        "서초구",
                                        "강남구",
                                        "송파구",
                                        "강동구"
                        },

                        // 부산시
                        {
                                        "전체/시/군",
                                        "중구",
                                        "서구",
                                        "동구",
                                        "영도구",
                                        "부산진구",
                                        "동래구",
                                        "남구",
                                        "북구",
                                        "강서구",
                                        "해운대구",
                                        "사하구",
                                        "금정구",
                                        "연제구",
                                        "수영구",
                                        "사상구",
                                        "기장군"
                        },

                        // 대구시
                        {
                                        "전체/시/군",
                                        "중구",
                                        "동구",
                                        "서구",
                                        "남구",
                                        "북구",
                                        "수성구",
                                        "달서구",
                                        "달성군"
                        },

                        // 인천시
                        {
                                        "전체/시/군",
                                        "중구",
                                        "동구",
                                        "미추홀구",
                                        "연수구",
                                        "남동구",
                                        "부평구",
                                        "계양구",
                                        "서구",
                                        "강화군",
                                        "옹진군"
                        },

                        // 광주시
                        {
                                        "전체/시/군",
                                        "동구",
                                        "서구",
                                        "남구",
                                        "북구",
                                        "광산구"
                        },

                        // 대전시
                        {
                                        "전체/시/군",
                                        "동구",
                                        "중구",
                                        "서구",
                                        "유성구",
                                        "대덕구"
                        },

                        // 울산시
                        {
                                        "전체/시/군",
                                        "중구",
                                        "남구",
                                        "동구",
                                        "북구",
                                        "울주군"
                        },

                        // 세종시
                        {
                                        "전체/시/군",
                                        "금남면",
                                        "부강면",
                                        "소정면",
                                        "연기면",
                                        "연동면",
                                        "연서면",
                                        "장군면",
                                        "전동면",
                                        "전의면",
                                        "조치원읍",
                                        "가람동",
                                        "고운동",
                                        "나성동",
                                        "다정동",
                                        "대평동",
                                        "도담동",
                                        "반곡동",
                                        "보람동",
                                        "산울동",
                                        "새롬동",
                                        "소담동",
                                        "아름동",
                                        "어진동",
                                        "종촌동",
                                        "집현동",
                                        "한솔동",
                                        "함강동",
                                        "해밀동"
                        },

                        // 경기도
                        {
                                        "전체/시/군",
                                        "고양시",
                                        "과천시",
                                        "광명시",
                                        "광주시",
                                        "구리시",
                                        "군포시",
                                        "김포시",
                                        "남양주시",
                                        "동두천시",
                                        "부천시",
                                        "성남시",
                                        "수원시",
                                        "시흥시",
                                        "안산시",
                                        "안성시",
                                        "안양시",
                                        "양주시",
                                        "오산시",
                                        "용인시",
                                        "의왕시",
                                        "의정부시",
                                        "이천시",
                                        "파주시",
                                        "평택시",
                                        "포천시",
                                        "하남시",
                                        "화성시",
                                        "연천군",
                                        "가평군",
                                        "양평군"
                        },

                        // 강원도
                        {
                                        "전체/시/군",
                                        "강릉시",
                                        "동해시",
                                        "삼척시",
                                        "속초시",
                                        "원주시",
                                        "춘천시",
                                        "태백시",
                                        "홍천군",
                                        "횡성군",
                                        "영월군",
                                        "평창군",
                                        "정선군",
                                        "철원군",
                                        "화천군",
                                        "양구군",
                                        "인제군",
                                        "고성군",
                                        "양양군"

                        },

                        // 충청북도
                        {
                                        "전체/시/군",
                                        "제천시",
                                        "청주시",
                                        "충주시",
                                        "보은군",
                                        "옥천군",
                                        "영동군",
                                        "증평군",
                                        "진천군",
                                        "괴산군",
                                        "음성군",
                                        "단양군"

                        },

                        // 충청남도
                        {
                                        "전체/시/군",
                                        "계룡시",
                                        "공주시",
                                        "논산시",
                                        "당진시",
                                        "보령시",
                                        "서산시",
                                        "아산시",
                                        "천안시",
                                        "금산군",
                                        "부여군",
                                        "서천군",
                                        "청양군",
                                        "홍성군",
                                        "예산군",
                                        "태안군"

                        },

                        // 경상북도
                        {
                                        "전체/시/군",
                                        "경산시",
                                        "경주시",
                                        "구미시",
                                        "김천시",
                                        "문경시",
                                        "상주시",
                                        "안동시",
                                        "영주시",
                                        "영천시",
                                        "포항시",
                                        "군위군",
                                        "의성군",
                                        "청송군",
                                        "영양군",
                                        "영덕군",
                                        "청도군",
                                        "고령군",
                                        "성주군",
                                        "칠곡군",
                                        "예천군",
                                        "봉화군",
                                        "울진군",
                                        "울릉군"
                        },

                        // 경상남도
                        {
                                        "전체/시/군",
                                        "거제시",
                                        "김해시",
                                        "밀양시",
                                        "사천시",
                                        "양산시",
                                        "진주시",
                                        "창원시",
                                        "통영시",
                                        "의령군",
                                        "함안군",
                                        "창녕군",
                                        "고성군",
                                        "남해군",
                                        "하동군",
                                        "산청군",
                                        "함양군",
                                        "거창군",
                                        "합천군"
                        },

                        // 전라북도
                        {
                                        "전체/시/군",
                                        "군산시",
                                        "김제시",
                                        "남원시",
                                        "익산시",
                                        "전주시",
                                        "정읍시",
                                        "완주군",
                                        "진안군",
                                        "무주군",
                                        "장수군",
                                        "임실군",
                                        "순창군",
                                        "고창군",
                                        "부안군"

                        },

                        // 전라남도
                        {
                                        "전체/시/군",
                                        "광양시",
                                        "나주시",
                                        "목포시",
                                        "순천시",
                                        "여수시",
                                        "담양군",
                                        "곡성군",
                                        "구례군",
                                        "고흥군",
                                        "보성군",
                                        "화순군",
                                        "장흥군",
                                        "강진군",
                                        "해남군",
                                        "영암군",
                                        "무안군",
                                        "함평군",
                                        "영광군",
                                        "장성군",
                                        "완도군",
                                        "진도군",
                                        "신안군"
                        },

                        // 제주특별자치도
                        {
                                        "전체/시/군",
                                        "서귀포시",
                                        "제주시" }
        };

        public String[][] getDoName() { // 전체, 서울시 ~ 광역시
                return doName;
        }

        public String[][] getSiNameList() { // 전체, 구, ,군

                return siNameList;
        }

        public String[] getType() {
                String[] type = {
                                "전체",
                                "일반야영장",
                                "자동차야영장",
                                "글램핑",
                                "카라반" };
                return type;
        }
}
