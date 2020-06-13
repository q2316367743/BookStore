// pages/shop/shop.js
import {userUrl} from '../../config'
import {comImgUrl} from '../../config'
import {shopUrl} from '../../config'

Page({

  /**
   * 页面的初始数据
   */
  data: {
    items: {},
    delBtnWidth: 160
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
      url: userUrl + 'shop',
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

  drawStart: function(e){
    //判断是否只有一个触摸点
    if(e.touches.length==1){
      this.setData({
        //记录触摸起始位置的X坐标
        startX:e.touches[0].clientX
      });
    }
  },

  drawMove: function(e){
    var that = this
    if(e.touches.length==1){
     //记录触摸点位置的X坐标
      var moveX = e.touches[0].clientX;
      //计算手指起始点的X坐标与当前触摸点的X坐标的差值
      var disX = that.data.startX - moveX;
     //delBtnWidth 为右侧按钮区域的宽度
      var delBtnWidth = that.data.delBtnWidth;
      var txtStyle = "";
      var delStyle = "";
      if(disX == 0 || disX < 0){//如果移动距离小于等于0，文本层位置不变
        txtStyle = "left:0px";
        delStyle = "right:-160rpx"
      }else if(disX > 0 ){//移动距离大于0，文本层left值等于手指移动距离
        delStyle = "right:" + (disX - 160) + "rpx"
        txtStyle = "left:-"+disX+"rpx";
        if(disX>=delBtnWidth){
          //控制手指移动距离最大值为删除按钮的宽度
          txtStyle = "left:-"+delBtnWidth+"rpx";
          delStyle = "right: 0rpx"
        }
      }
      var index = e.currentTarget.dataset.index;
      var list = that.data.items;
      //将拼接好的样式设置到当前item中
      list[index].txtStyle = txtStyle; 
      list[index].delStyle = delStyle;
      //更新列表的状态
      this.setData({
       items:list
      });
    }
  },

  drawEnd: function(e){
    var that = this
    if(e.changedTouches.length==1){
      //手指移动结束后触摸点位置的X坐标
      var endX = e.changedTouches[0].clientX;
      //触摸开始与结束，手指移动的距离
      var disX = that.data.startX - endX;
      var delBtnWidth = that.data.delBtnWidth;
      //如果距离小于删除按钮的1/2，不显示删除按钮
      var txtStyle = disX > delBtnWidth/2 ? "left:-"+delBtnWidth+"rpx":"left:0rpx";
      var delStyle = disX > delBtnWidth/2 ? "right: 0rpx":"right: -"+delBtnWidth+"rpx";
      //获取手指触摸的是哪一项
      var index = e.currentTarget.dataset.index;
      var list = that.data.items;
      list[index].txtStyle = txtStyle;
      list[index].delStyle = delStyle;
      //更新列表的状态
      that.setData({
        items:list
      });
    }
  },

  del: function(e){
    let that = this
    var id = e.currentTarget.dataset.id;
    wx.showLoading({
      title: '删除中',
      mask: true
    })
    wx.request({
      url: shopUrl + 'remove',
      data: {
        token: wx.getStorageSync('token'),
        commodityId: id
      },
      success: function(res){
        if(res.data.code == 200){
          wx.hideLoading({
            complete: (res) => {
              wx.showToast({
                title: '删除成功',
                icon: 'success',
                duration: 2000
              })
              that.onLoad()
            },
          })
        }else{
          wx.showModal({
            title: '提示',
            content: '删除失败',
            showCancel: false,
            confirmText: "确定",
            success: function (res) {
              
            }
          })
        }
      }
    })
  }

})