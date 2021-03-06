import React, { useEffect } from "react";
import Layout from "../../components/layout";
import { Table, Button } from "react-bootstrap";
import { useRouter } from "next/router";
import { useDispatch, useSelector } from "react-redux";
import { AppDispatch, RootState } from "../../provider";
import { getTimeString } from "../../lib/string";
import { requestFetchInquiryItem } from "../../middleware/modules/inquiry";
import style from "../../pages/onedayclass/hover.module.css";

const List = () => {
  const inquiry = useSelector((state: RootState) => state.inquiry);
  const router = useRouter();
  const dispatch = useDispatch<AppDispatch>();
  const id = router.query.id as string;
  console.log(id);

  let inquiryItem = useSelector((state: RootState) =>
    state.inquiry.data.find((item) => item.inquiryId === +id)
  );

  useEffect(() => {
    dispatch(requestFetchInquiryItem());
  }, [dispatch]);

  return (
    <Layout>
      <div className="mx-auto">
        <div className="text-center">
          <h1
            style={{
              fontWeight: "lighter",
              color: "#4f5d75",
              textDecorationLine: "underline",
              textUnderlinePosition: "under",
            }}
          >
            1:1문의 내역
          </h1>
          <h6 className="text-muted  mt-3">
            고객님께서 문의한 1:1 내역입니다.
          </h6>
        </div>
        <div className="justify-content-md-center d-flex">
          <Table
            responsive="sm"
            style={{ cursor: "pointer", width: "800px" }}
            className="text-center  mt-3"
            // hover
          >
            <thead>
              <tr
                style={{
                  marginRight: "250px",
                  fontWeight: "lighter",
                  color: "#4f5d75",
                }}
              >
                {/* <th>#</th> */}
                <th>문의클래스</th>
                <th>제목</th>
                <th>작성자</th>
                <th>연락처</th>
                <th>DATE</th>
                {/* <th>자세히보기</th> */}
              </tr>
            </thead>
            <tbody className={style.hover}>
              {inquiry.data.map((item, index) => (
                <tr
                  key={`inquiry-item-${index}`}
                  onClick={() => {
                    router.push(`/inquiry/detail/${item.inquiryId}`);
                  }}
                >
                  {/* <td>{item.inquiryId}</td> */}
                  <td>{item.oneDayClassName}</td>
                  <td>{item.title}</td>
                  <td>{item.name}</td>
                  <td>{item.tel}</td>
                  <td>{getTimeString(item.createdTime)}</td>
                  {/* <td style={{ width: "130px" }}>
                <Button
                  className="bg-light "
                  size="sm"
                  onClick={() => {
                    router.push(`/inquiry/detail/${item.inquiryId}`);
                  }}
                >
                  {" "}
                  자세히
                </Button>
              </td> */}
                </tr>
              ))}
            </tbody>
          </Table>
        </div>
      </div>
    </Layout>
  );
};

export default List;
