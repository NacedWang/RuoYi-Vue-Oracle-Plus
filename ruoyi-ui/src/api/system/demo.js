import request from '@/utils/request'

// 查询Demo列表
export function listDemo(query) {
  return request({
    url: '/system/demo/list',
    method: 'get',
    params: query
  })
}

// 查询Demo详细
export function getDemo(id) {
  return request({
    url: '/system/demo/' + id,
    method: 'get'
  })
}

// 新增Demo
export function addDemo(data) {
  return request({
    url: '/system/demo',
    method: 'post',
    data: data
  })
}

// 修改Demo
export function updateDemo(data) {
  return request({
    url: '/system/demo',
    method: 'put',
    data: data
  })
}

// 删除Demo
export function delDemo(id) {
  return request({
    url: '/system/demo/' + id,
    method: 'delete'
  })
}

// 导出Demo
export function exportDemo(query) {
  return request({
    url: '/system/demo/export',
    method: 'get',
    params: query
  })
}