// pages/register/register.js
import {userUrl} from '../../config'
Page({

  /**
   * 页面的初始数据
   */
  data: {

  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {

  },
  formSubmit(e) {
    var data = e.detail.value
    console.log(data)
    /*wx.request({
      url: userUrl + 'register',
      data: data,
      success: res => {

      }
    })*/
  }

})