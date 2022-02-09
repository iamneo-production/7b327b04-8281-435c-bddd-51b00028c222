import React from "react";

const BannerComp = () => {
  return (
    <>
      <div
        style={{
          backgroundImage: "url(/banner-bg.png)",
          backgroundSize: "cover",
          backgroundColor: "#000a26",
          backgroundRepeat: "no-repeat",
          height: "90vh",
        }}
      >
        <div className="container h-100">
          <div className="row h-100 d-flex align-items-center">
            <div className="col-md-5 col-sm-12">
              <div className="d-flex flex-column justify-content-center text-white">
                <h1 className="text-left">Event Management System</h1>
                <p className="text-left fs-20">
                  Lorem ipsum, dolor sit amet consectetur adipisicing elit.
                  Neque totam deserunt eaque molestias dignissimos tempore
                  beatae rerum debitis error.
                </p>
              </div>
            </div>
            <div className="col-md-7 col-sm-12">
              <div className="d-flex flex-column justify-content-center">
                <img className="w-100" src="/banner-ai.svg" alt="banner svg" />
              </div>
            </div>
          </div>
        </div>
      </div>
    </>
  );
};

export default BannerComp;
