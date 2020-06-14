// pages/category/category.js
import {globalUrl} from '../../config'
import {comImgUrl} from '../../config'
import {searchUrl} from '../../config'
Page({

  /**
   * 页面的初始数据
   */
  data: {
    categories: [],
    commodities: [],
    curIndex: 0,
    comImgUrl: ''
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    this.setData({
      comImgUrl: comImgUrl
    })
    let that = this;
    //分类获取
    wx.request({
      url: globalUrl + 'category',
      success: res=> {
        var result = res.data;
        if(result.code == 200){
          that.setData({
            categories: result.categories
          })
        }else{
          wx.showModal({
            title: '提示',
            content: '分类信息获取错误，请重试',
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
  },
  switchRightTab: function(e){
    let that = this
    var index = parseInt(e.currentTarget.dataset.index);
    var name = e.currentTarget.dataset.name;
    this.setData({
      curIndex: index
    })
    wx.request({
      url: searchUrl + 'category',
      data: {
        category: name,
        page: 1,
        limit: 9
      },
      success: res => {
        var result = res.data
        if(result.code == 200){
          that.setData({
            commodities: result.data
          })
        }else{
          wx.showToast({
            title: '分类错误',
            icon: 'none',
            duration: 2000
          })
        }
      }
    })
  }
})