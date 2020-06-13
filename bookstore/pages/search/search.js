// pages/search/search.js
import {searchUrl} from '../../config'
import {comImgUrl} from '../../config'
Page({

  /**
   * 页面的初始数据
   */
  data: {
    inputShowed: false,
    commodities: {},
    comImgUrl: ''
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    this.setData({
      comImgUrl: comImgUrl
    })
  },
  showInput: function () {
    this.setData({
        inputShowed: true
    });
  },
  hideInput: function () {
    this.setData({
        inputVal: "",
        inputShowed: false,
        commodities: {}
    });
  },
  clearInput: function () {
    this.setData({
        inputVal: ""
    });
  },
  inputTyping: function (e) {
    let that = this
    var value = e.detail.value;
    this.setData({
        inputVal: e.detail.value
    });
    wx.showLoading({
      title: '搜索中',
      mask: true
    })
    wx.request({
      url: searchUrl + 'base',
      data: {
        commodityName: value,
        page: 1,
        limit: 9
      },
      success: res => {
        wx.hideLoading({
          complete: (res) => {},
        })
        var result = res.data
        if(result.code == 200){
          that.setData({
            commodities: result.data
          })
        }else{
          wx.showModal({
            title: '提示',
            content: result.msg,
            showCancel: false,
            confirmText: "确定",
            success: function (res) {
              wx.switchTab({
                url: '/pages/index/index',
              })
            }
          })
        }
      }
    })
  }
})