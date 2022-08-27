<template>
  <div class="app-container">
    <Header title="购物车"></Header>
    <Goods v-for="item in list" :key="item.id" :id="item.id" :title="item.goods_name" :pic="item.goods_img"
           :price="item.goods_price" :count="item.goods_count" :checked="item.goods_state"
           @change-status="getNewStatus"/>
    <Footer :isFull="fullStatus" @full-change-status="getFllNewStatus" :totalAmount="totalAmount"
            :totalCount="totalCount"/>
  </div>
</template>

<script>

import axios from 'axios'
import Header from '@/components/Header/Header.vue'
import Goods from '@/components/Goods/Goods.vue'
import Footer from "@/components/Footer/Footer";
import eventBus from "@/components/eventBus.js";

export default {

  data() {
    return {
      list: []
    }
  },

  components: {
    Header,
    Goods,
    Footer
  },

  created() {
    this.initCart()

    eventBus.$on('share', (id, count) => {
      console.log(id, count)
      this.list.some(item => {
        if (item.id === id) {
          item.goods_count = count
          return true
        }
      })
    })
  },

  //计算属性
  computed: {
    fullStatus() {
      return this.list.every(item => item.goods_state)
    },

    totalAmount() {
      return this.list.filter(item => item.goods_state).reduce((total, item) => total + item.goods_price * item.goods_count, 0)
    },

    totalCount() {
      return this.list.filter(item => item.goods_state).reduce((total, item) => total + item.goods_count, 0)
    }
  },

  methods: {
    async initCart() {
      const {data: result} = await axios.get('https://www.escook.cn/api/cart')
      if (result.status === 200) {
        this.list = result.list
      }
    },

    getNewStatus(id, status) {
      this.list.some((item) => {
        if (item.id === id) {
          item.goods_state = status
          return true
        }
      })
    },

    getFllNewStatus(status) {
      this.list.forEach(item => {
        item.goods_state = status
      })
    }

  }
}

</script>

<style lang="less" scoped>
.app-container {
  padding-top: 45px;
  padding-bottom: 50px;
}
</style>
