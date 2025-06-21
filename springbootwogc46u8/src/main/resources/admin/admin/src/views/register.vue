<template>
	<div>
		<div class="container" :style='{"minHeight":"100vh","alignItems":"center","background":"url(http://codegen.caihongy.cn/20231118/03ccfac983fd4dac8fa98ccb357ee0dc.jpg)","display":"flex","width":"100%","backgroundSize":"100% 100%","backgroundPosition":"center center","backgroundRepeat":"no-repeat","justifyContent":"center"}'>
			<el-form v-if="pageFlag=='register'" :style='{"border":"0px solid #f6f6f6","padding":"40px 40px 40px 580px","boxShadow":"-15px 15px 15px rgb(6 17 47 / 70%)","margin":"20px 0","alignItems":"flex-start","textAlign":"center","display":"flex","justifyContent":"flex-start","minHeight":"600px","borderRadius":"0px","flexWrap":"wrap","background":"url(http://codegen.caihongy.cn/20231118/bc6bba657fa6436aa66620dcc5270163.jpg) repeat-y right center,url(http://codegen.caihongy.cn/20231118/ef8fde72b1aa416588d23b09f1998967.jpg) no-repeat right center / cover,#fff","width":"880px","height":"auto"}' ref="rgsForm" class="rgs-form" :model="rgsForm" :rules="rules">
				<div v-if="true" :style='{"padding":"0px","margin":"0 0 10px","borderColor":"#eee","color":"#2b9afc","textAlign":"left","display":"inline-block","background":"none","borderWidth":"0px","width":"100%","lineHeight":"40px","fontSize":"20px","borderStyle":"solid","fontWeight":"500"}' class="title">国内旅游景点的数据爬虫与可视化分析注册</div>
				<button :style='{"border":"0px solid #4FA1D9","cursor":"pointer","padding":"0 24px","boxShadow":"0 0 0px rgba(64, 158, 255, .5)","margin":"20px 20px 0 0","color":"#fff","display":"inline-block","letterSpacing":"4px","outline":"none","borderRadius":"4px","background":"#2b9afc","width":"auto","fontSize":"16px","height":"40px"}' type="button" class="r-btn" @click="login()">注册</button>
				<div :style='{"cursor":"pointer","padding":"0","margin":"20px 0 0","color":"rgba(159, 159, 159, 1)","textAlign":"right","display":"inline-block","width":"auto","lineHeight":"44px","fontSize":"14px"}' class="r-login" @click="close()">已有账号，直接登录</div>
			</el-form>
			
		</div>
	</div>
</template>

<script>
export default {
	data() {
		return {
			ruleForm: {
			},
			forgetForm: {},
            pageFlag : '',
			tableName:"",
			rules: {},
		};
	},
	mounted(){
		this.pageFlag = this.$route.query.pageFlag
		if(this.$route.query.pageFlag=='register'){
			
			let table = this.$storage.get("loginTable");
			this.tableName = table;
		}
	},
	created() {
	},
	destroyed() {
		  	},
	methods: {
		changeRules(name){
			if(this.rules[name]){
				return true
			}
			return false
		},
		// 获取uuid
		getUUID () {
			return new Date().getTime();
		},
		close(){
			this.$router.push({ path: "/login" });
		},

        // 多级联动参数


		// 注册
		login() {
			var url=this.tableName+"/register";
			this.$http({
				url: url,
				method: "post",
				data:this.ruleForm
			}).then(({ data }) => {
				if (data && data.code === 0) {
					this.$message({
						message: "注册成功",
						type: "success",
						duration: 1500,
						onClose: () => {
							this.$router.replace({ path: "/login" });
						}
					});
				} else {
					this.$message.error(data.msg);
				}
			});
		}
	}
};
</script>

<style lang="scss" scoped>
	.container {
	  position: relative;
	  background: url(http://codegen.caihongy.cn/20231118/03ccfac983fd4dac8fa98ccb357ee0dc.jpg);

		.el-date-editor.el-input {
		  width: 100%;
		}
		
		.rgs-form .el-input /deep/ .el-input__inner {
						border: 1px solid #eee;
						border-radius: 4px;
						padding: 0 10px;
						box-shadow: 0 0 0px rgba(64, 158, 255, .3);
						color: #666;
						background: none;
						width: 100%;
						font-size: 14px;
						min-width: 220px;
						height: 36px;
					}
		
		.rgs-form .el-select /deep/ .el-input__inner {
						border: 1px solid #eee;
						border-radius: 4px;
						padding: 0 10px;
						box-shadow: 0 0 0px rgba(64, 158, 255, .3);
						color: #ccc;
						background: none;
						width: 100%;
						font-size: 14px;
						min-width: 220px;
						height: 36px;
					}
		
		.rgs-form .el-date-editor /deep/ .el-input__inner {
						border: 1px solid #eee;
						border-radius: 4px;
						padding: 0 10px 0 30px;
						box-shadow: 0 0 0px rgba(64, 158, 255, .3);
						color: #ccc;
						background: none;
						width: 100%;
						font-size: 14px;
						min-width: 220px;
						height: 36px;
					}
		
		.rgs-form .el-date-editor /deep/ .el-input__inner {
						border: 1px solid #eee;
						border-radius: 4px;
						padding: 0 10px 0 30px;
						box-shadow: 0 0 0px rgba(64, 158, 255, .3);
						color: #ccc;
						background: none;
						width: 100%;
						font-size: 14px;
						min-width: 220px;
						height: 36px;
					}
		
		.rgs-form /deep/ .el-upload--picture-card {
			background: transparent;
			border: 0;
			border-radius: 0;
			width: auto;
			height: auto;
			line-height: initial;
			vertical-align: middle;
		}
		
		.rgs-form /deep/ .upload .upload-img {
		  		  border: 1px solid #eee;
		  		  cursor: pointer;
		  		  border-radius: 4px;
		  		  margin: 2px 0 0;
		  		  color: #999;
		  		  background: none;
		  		  font-weight: 600;
		  		  width: 100px;
		  		  font-size: 18px;
		  		  line-height: 36px;
		  		  text-align: center;
		  		  height: 36px;
		  		}
		
		.rgs-form /deep/ .el-upload-list .el-upload-list__item {
		  		  border: 1px solid #eee;
		  		  cursor: pointer;
		  		  border-radius: 4px;
		  		  margin: 2px 0 0;
		  		  color: #999;
		  		  background: none;
		  		  font-weight: 600;
		  		  width: 100px;
		  		  font-size: 18px;
		  		  line-height: 36px;
		  		  text-align: center;
		  		  height: 36px;
		  		}
		
		.rgs-form /deep/ .el-upload .el-icon-plus {
		  		  border: 1px solid #eee;
		  		  cursor: pointer;
		  		  border-radius: 4px;
		  		  margin: 2px 0 0;
		  		  color: #999;
		  		  background: none;
		  		  font-weight: 600;
		  		  width: 100px;
		  		  font-size: 18px;
		  		  line-height: 36px;
		  		  text-align: center;
		  		  height: 36px;
		  		}
	}
	.required {
		position: relative;
	}
	.required::after{
				color: red;
				position: absolute;
				right: 3px;
				content: "*";
				order: 3;
			}
	.editor>.avatar-uploader {
		line-height: 0;
		height: 0;
	}
</style>
