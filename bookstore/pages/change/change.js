// pages/change/change.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    translate: {
      "nickname": "昵称",
      "gender": "性别",
      "age": "年龄",
      "password": "密码"
    },
    changeWhat: '',
    oldValue: '',
    newValue: '',
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var changeWhat = options.changeWhat;
    var userinfo = wx.getStorageSync('userinfo');
    this.setData({
      changeWhat: changeWhat,
      oldValue: userinfo[changeWhat]
    })
    if(changeWhat == "gender"){
      this.setData({
        oldValue: userinfo[changeWhat]?'男':'女'
      })
    }
    wx.setNavigationBarTitle({
      title: '修改' + this.data.translate[changeWhat]
    })
  },

  change: function(res){
    this.setData({ 
      newValue: res.detail.value 
    }) 
  },

  oldPWD: function(res){
    this.setData({ 
      oldValue: res.detail.value 
    }) 
  },

  newPWD: function(res){
    this.setData({ 
      newValue: res.detail.value 
    }) 
  },

  bindSubmit: function(){
    if(this.data.changeWhat == "gender"){
      this.data.newValue = this.data.newValue=='男'?true:false
    }
    console.log(this.data.newValue)
  },

  changePWD: function(){
    console("old:"+this.data.oldValue+",new:"+this.data.newValue)
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  }
})