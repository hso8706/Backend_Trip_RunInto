// const axios = require("axios");
axios.defaults.baseURL = "http://apis.data.go.kr/B551011/KorService1/";

var json;
// 지역기반 관광정보 조회
async function getAreaList() {
  try {
    const res = await axios.get("/areaBasedList1", {
      params: {
        _type: "json",
        MobileOS: "WIN",
        MobileApp: "runinto",
        ServiceKey:
          // process.env.API_SERVICE_KEY,
          "zwSMywdlgo3E03aEm4hFNEzkpaACYU80Fp/lGBjG7Q1b4TGfAbc+/w85V/Ge6H9XPBzoZecK2Jf4fEfuwd0zdA==",
      },
    });
    json = res.data.response.body.items.item;
  } catch (error) {
    console.log(error);
  }
}

async function getDetailCommon(contentId) {
  try {
    const res = await axios.get("/detailCommon1", {
      params: {
        _type: "json",
        MobileOS: "WIN",
        MobileApp: "runinto",
        contentId: contentId,
        defaultYN: "Y",
        firstImageYN: "Y",
        addrinfoYN: "Y",
        ServiceKey:
          // process.env.API_SERVICE_KEY,
          "zwSMywdlgo3E03aEm4hFNEzkpaACYU80Fp/lGBjG7Q1b4TGfAbc+/w85V/Ge6H9XPBzoZecK2Jf4fEfuwd0zdA==",
      },
    });
    json = res.data.response.body.items.item;
  } catch (error) {
    console.log(error);
  }
}

async function main() {
  let contentId = 126508;

  for (let i = 1; i <= 4; i++) {
    const curId = contentId + i - 1;

    await getDetailCommon(curId);
    console.log(json);
    let img = document.getElementById(`section1-img${i}`);
    let title = document.getElementById(`section1-title${i}`);
    img.setAttribute("src", json[0].firstimage);
    title.innerText = json[0].title;
    document.getElementById(`section1-addr${i}`).innerText = json[0].addr1;
  }
}

main();
