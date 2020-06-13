// pages/record/record.js
import {userUrl} from '../../config'
import {comImgUrl} from '../../config'
import {shopUrl} from '../../config'
import {resourceUrl} from '../../config'

Page({

  /**
   * 页面的初始数据
   */
  data: {
    items: {},
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var self=this
    this.setData({
      comImgUrl: comImgUrl
    })
    wx.request({
      url: userUrl + 'record',
      data: {
        token: wx.getStorageSync('token'),
        page: 1,
        limit: 9
      },
      success: function(res){
        if(res.data.code == 200){
          self.setData({
            items: res.data.data
          })
        }else{
          wx.showModal({
            title: '提示',
            content: res.data.msg,
            showCancel: false,
            confirmText: "确定",
            success: function (res) {
              wx.navigateTo({
                url: '/pages/index/index',
              })
            }
          })
        }
      }
    })
  },

  download: function(e){
    var id = e.currentTarget.dataset.id;
    var token = wx.getStorageSync('token')
    wx.showLoading({
      title: '获取下载连接中',
    })
    wx.request({
      url: shopUrl + 'getDownloadPath',
      data: {
        token: token,
        commodityId: id
      },
      success: function(res){
        var result = res.data
        wx.hideLoading({
          complete: (res) => {
            
          },
        })
        var key = result
        var url = resourceUrl + 'download?token=' +key;
        wx.setClipboardData({
          data: url,
          success: function(e){
            wx.showToast({
              title: '已将链接复制到剪切板',
              icon: 'success',
              duration: 2000
            })
          }
        })
      }
    })
  }

})